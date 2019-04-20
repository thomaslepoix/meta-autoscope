FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_raspberrypi3 += " \
	file://0001-Autoscope-logo.patch \
	file://logo.cfg \
	file://debug.cfg \
	file://logo_autoscope_clut224.ppm \
	"

do_patch_prepend() {
    cp ${WORKDIR}/logo_autoscope_clut224.ppm ${S}/drivers/video/logo/
}

KERNEL_MODULE_AUTOLOAD_append = " ip_tables"

CMDLINE_append = "quiet console=tty2"