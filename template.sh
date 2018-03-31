#!/bin/bash

if [ -z "$1" ]; then
    echo "$0 com.example.app"
    exit 0
fi

PKG="$1"
ORIGIN_PATH="org.xdty.template"

find ./app -type f -exec sed -i "s/${ORIGIN_PATH//./\\.}/$PKG/g" {} \;
find ./app -type f -name *.cpp -exec sed -i "s/${ORIGIN_PATH//./_}/${PKG//./_}/g" {} \;

ORIGIN_PATH="${ORIGIN_PATH//./\/}"
PKG_PATH="${PKG//./\/}"

mkdir -p "app/src/androidTest/java/${PKG_PATH}"
mkdir -p "app/src/debug/java/${PKG_PATH}"
mkdir -p "app/src/main/java/${PKG_PATH}"
mkdir -p "app/src/test/java/${PKG_PATH}"

mv app/src/androidTest/java/$ORIGIN_PATH/* "app/src/androidTest/java/${PKG_PATH}"
mv app/src/debug/java/$ORIGIN_PATH/* "app/src/debug/java/${PKG_PATH}"
mv app/src/main/java/$ORIGIN_PATH/* "app/src/main/java/${PKG_PATH}"
mv app/src/test/java/$ORIGIN_PATH/* "app/src/test/java/${PKG_PATH}"

rm -r "app/src/androidTest/java/$ORIGIN_PATH"
rm -r "app/src/debug/java/$ORIGIN_PATH"
rm -r "app/src/main/java/$ORIGIN_PATH"
rm -r "app/src/test/java/$ORIGIN_PATH"

find . -type d -empty -delete
find . -type d -empty -delete
