#!/bin/sh

for file in *.svg
do
inkscape -z -e  $(echo "$file" | cut -d'.' -f 1).png -w 200 -h 200 "$file"
done 
