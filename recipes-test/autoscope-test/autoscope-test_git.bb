SUMMARY = "Test suite for Autoscope programs"
DESCRIPTION = "These test programs are fragments for future Autoscope-core program"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/thibaudledo/Autoscope;protocol=git;branch=master"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

do_compile () {
	#mtk3339d
	${CC} ${CFLAGS} ${LDFLAGS} ${S}/mtk3339d-test.c -o ${WORKDIR}/mtk3339d-test
	#a4988
	${CC} ${CFLAGS} ${LDFLAGS} ${S}/a4988-test.c -o ${WORKDIR}/a4988-test
}

do_install_append () {
	#mtk3339d
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/mtk3339d-test ${D}${bindir}/
	#a4988
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/a4988-test ${D}${bindir}/
}

#ALLOW_EMPTY_${PN} = "1"

PACKAGES =+ "${PN}-mtk3339d ${PN}-a4988"
FILES_${PN}-mtk3339d = "${bindir}/mtk3339d-test"
FILES_${PN}-a4988 = "${bindir}/a4988-test"
