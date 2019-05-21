SUMMARY = "GPS daemon"
SECTION = "daemon"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHT;md5=349c872e0066155e1818b786938876a4"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/thibaudledo/Autoscope;protocol=git;branch=mtk3339d"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit update-rc.d

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} ${S}/mtk3339d.c ${S}/parser.c ${S}/uart.c -o ${WORKDIR}/mtk3339d
}

do_install () {
	install -d ${D}${sysconfdir}/init.d
	cat ${S}/mtk3339d.sh | \
	  sed -e 's,/etc,${sysconfdir},g' \
	      -e 's,/usr/sbin,${sbindir},g' \
	      -e 's,/var,${localstatedir},g' \
	      -e 's,/usr/bin,${bindir},g' \
	      -e 's,/usr,${prefix},g' > ${D}${sysconfdir}/init.d/mtk3339d
	chmod 0755 ${D}${sysconfdir}/init.d/mtk3339d

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/mtk3339d ${D}${bindir}/
}

INITSCRIPT_NAME = "mtk3339d"
INITSCRIPT_PARAMS = "start 80 5 . stop 00 0 1 6 ."
