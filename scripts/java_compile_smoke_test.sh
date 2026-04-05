#!/usr/bin/env bash
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$repo_root"

mapfile -t java_files < <(find . -type f -name '*.java' -not -path './.git/*' | sort)

if [ ${#java_files[@]} -eq 0 ]; then
  echo "No Java files found."
  exit 0
fi

tmp_dir="$(mktemp -d)"
trap 'rm -rf "$tmp_dir"' EXIT

echo "Compiling ${#java_files[@]} Java files..."

for file in "${java_files[@]}"; do
  echo "-> $file"
  javac -d "$tmp_dir" "$file"
done

echo "Java compile smoke test passed."
