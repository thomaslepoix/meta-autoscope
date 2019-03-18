FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://main.conf \
	file://settings \
"

#INSANE_SKIP_${PN} += "installed-vs-shipped"
FILES_${PN} += "${sysconfdir}/*"

do_install_append() {
	install -d ${D}${sysconfdir}/connman/
	install -m 0755 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/main.conf
	install -d ${D}${localstatedir}/lib/connman/
	install -m 0755 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman/settings
}
