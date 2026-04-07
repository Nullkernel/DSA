#!/usr/bin/env bash
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$repo_root"

examples=(
  "Data-Structures/Queue/BoundedQueue.java"
)

tmp_dir="$(mktemp -d)"
trap 'rm -rf "$tmp_dir"' EXIT

failures=0

echo "Runtime smoke test: compiling and executing ${#examples[@]} Java example(s)..."

for i in "${!examples[@]}"; do
  source_file="${examples[$i]}"

  if [[ ! -f "$source_file" ]]; then
    echo "[FAIL] $source_file"
    echo "  File not found."
    failures=$((failures + 1))
    continue
  fi

  class_name="$(basename "$source_file" .java)"
  work_dir="$tmp_dir/work/$i"
  out_dir="$tmp_dir/out/$i"
  output_file="$tmp_dir/output/$i.log"

  mkdir -p "$work_dir" "$out_dir" "$(dirname "$output_file")"

  compile_target="$work_dir/$source_file"
  mkdir -p "$(dirname "$compile_target")"
  cp "$source_file" "$compile_target"

  if ! javac -d "$out_dir" "$compile_target" >"$output_file" 2>&1; then
    echo "[FAIL] $source_file"
    sed 's/^/  /' "$output_file"
    failures=$((failures + 1))
    continue
  fi

  if ! java -cp "$out_dir" "$class_name" >>"$output_file" 2>&1; then
    echo "[FAIL] $source_file"
    sed 's/^/  /' "$output_file"
    failures=$((failures + 1))
    continue
  fi

  if grep -q "Exception in thread" "$output_file"; then
    echo "[FAIL] $source_file"
    echo "  Detected uncaught exception signature in runtime output."
    sed 's/^/  /' "$output_file"
    failures=$((failures + 1))
    continue
  fi

  echo "[PASS] $source_file"
done

if [[ $failures -gt 0 ]]; then
  echo
  echo "Java runtime smoke test failed: $failures example(s) failed runtime checks."
  exit 1
fi

echo
echo "Java runtime smoke test passed."
