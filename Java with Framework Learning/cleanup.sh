#!/bin/bash

# This script recursively finds and deletes specific files and directories
# from the directory where it is run.

# WARNING: This action is irreversible. Use with caution.

# Set the target directory to the current directory
SEARCH_DIR="."

# --- User Confirmation ---
echo "This script will permanently delete the following items from the current directory and all subdirectories:"
echo
echo "Directories: .git, .vscode"
echo "Files      : .gitignore, commit-command.sh, env.json, history_log.txt, install-extensions.sh, pom.xml"
echo
echo "‼️  WARNING: This action cannot be undone. ‼️"
echo

read -p "Are you absolutely sure you want to proceed? (Type 'yes' to continue): " CONFIRMATION

if [[ "$CONFIRMATION" != "yes" ]]; then
  echo "Operation cancelled by user."
  exit 1
fi

# --- Deletion Process ---

echo
echo "Searching for and deleting directories..."
# Find and delete the specified directories (.git, .vscode)
find "$SEARCH_DIR" -type d \( -name ".git" -o -name ".vscode" \) -prune -exec rm -rf {} +

echo "Searching for and deleting files..."
# Find and delete the specified files
find "$SEARCH_DIR" -type f \( \
  -name ".gitignore" -o \
  -name "commit-command.sh" -o \
  -name "env.json" -o \
  -name "history_log.txt" -o \
  -name "install-extensions.sh" -o \
  -name "pom.xml" \
\) -exec rm -f {} +

echo
echo "✅ Cleanup complete."