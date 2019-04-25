SUMMARY = "Helloworld daemon test"
SECTION = "base"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHT;md5=349c872e0066155e1818b786938876a4"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

#	   file://COPYRIGHT
SRC_URI = "file://helloworld.sh \
	   file://helloworld.c \
	   "
inherit update-rc.d

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/helloworld.c -o ${WORKDIR}/helloworld
}

do_install () {
	install -d ${D}${sysconfdir}/init.d
	cat ${WORKDIR}/helloworld.sh | \
	  sed -e 's,/etc,${sysconfdir},g' \
	      -e 's,/usr/sbin,${sbindir},g' \
	      -e 's,/var,${localstatedir},g' \
	      -e 's,/usr/bin,${bindir},g' \
	      -e 's,/usr,${prefix},g' > ${D}${sysconfdir}/init.d/helloworld
	chmod 0755 ${D}${sysconfdir}/init.d/helloworld

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/helloworld ${D}${bindir}/
}

#RDEPENDS_${PN} = "initscripts"
#CONFFILES_${PN} += "${sysconfdir}/init.d/helloworld"

INITSCRIPT_NAME = "helloworld"
INITSCRIPT_PARAMS = "start 99 5 . stop 00 0 1 6 ."
