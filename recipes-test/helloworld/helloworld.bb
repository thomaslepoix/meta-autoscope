SUMMARY = "Helloworld program test"
SECTION = "base"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHT;md5=349c872e0066155e1818b786938876a4"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

#		file://COPYRIGHT
#		file://helloworld.sh
SRC_URI = " \
	   file://helloworld.c \
	   "
do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/helloworld.c -o ${WORKDIR}/helloworld
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/helloworld ${D}${bindir}/
}

