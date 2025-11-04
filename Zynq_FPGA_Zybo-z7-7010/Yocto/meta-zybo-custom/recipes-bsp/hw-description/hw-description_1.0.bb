DESCRIPTION = "Zybo Z7 Hardware Description (XSA)"
LICENSE = "CLOSED"
SRC_URI = "file://design_1_wrapper.xsa"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/boot
    install -m 0644 ${S}/design_1_wrapper.xsa ${D}/boot/
}

FILES_${PN} += "/boot/design_1_wrapper.xsa"

