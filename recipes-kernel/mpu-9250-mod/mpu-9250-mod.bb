SUMMARY = "Inertial Measurement Unit implementation"

DESCRIPTION = "Kernel module driver"

LICENSE = "GPL"

#
# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

inherit module

SRC_URI += " \
	file://Makefile \
"

S = "${WORKDIR}"
