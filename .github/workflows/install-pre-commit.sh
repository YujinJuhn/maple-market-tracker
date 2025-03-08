#!/bin/bash

HOOKS_DIR=".git/hooks"
PRE_COMMIT_HOOK="${HOOKS_DIR}/pre-commit"

if [ ! -d "$HOOKS_DIR" ]; then
    mkdir -p "$HOOKS_DIR"
fi

cp .github/workflows/pre-commit "$PRE_COMMIT_HOOK"

chmod +x "$PRE_COMMIT_HOOK"

echo "Pre-commit hook has been installed successfully!"
