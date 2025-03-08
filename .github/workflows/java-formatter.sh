#!/bin/bash

for file in "$@"; do
    if [ -f "$file" ]; then
        echo "Formatting file: $file"
        java -jar .github/workflows/java_format/google-java-format-1.25.2-all-deps.jar -a -r "$file"
    elif [ -d "$file" ]; then
        echo "Processing directory: $file"
        find "$file" -name "*.java" -type f -exec java -jar .github/workflows/java_format/google-java-format-1.25.2-all-deps.jar -a -r {} \;
    else
        echo "Warning: $file does not exist"
    fi
done
