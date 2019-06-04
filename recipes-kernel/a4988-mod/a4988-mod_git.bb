SUMMARY = "Autoscope motors controllers Linux kernel module"
LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

inherit module

#SRC_URI = "file://Makefile \
#           file://a4988.c \
#           file://COPYING \
#          "

SRC_URI = "git://github.com/thibaudledo/Autoscope;protocol=git;branch=a4988_mod"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} += "kernel-module-a4988"

KERNEL_MODULE_AUTOLOAD_append = "a4988"
