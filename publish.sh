#!/bin/bash
BLUE='\e[1;34m'
RESET='\e[0m'
VERSION="6.3.7"
ARCHIVE="ezDMS-${VERSION}.zip"

# Build package
echo -e ${BLUE} "** Build $ARCHIVE..." ${RESET}
cd target
md5sum ezDMS.war > md5sum.txt
zip $ARCHIVE ezDMS.war md5sum.txt
