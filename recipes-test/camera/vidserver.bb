SUMMARY = "Web video streamer"
SECTION = "base"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHT;md5=349c872e0066155e1818b786938876a4"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

#		file://COPYRIGHT
#		file://helloworld.sh
SRC_URI = " \
	   file://vidserver.py \
	   "

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/vidserver.py ${D}${bindir}/vidserver
}

RDEPENDS_${PN} = "picamera ${PYTHON_PN}-websockets"
