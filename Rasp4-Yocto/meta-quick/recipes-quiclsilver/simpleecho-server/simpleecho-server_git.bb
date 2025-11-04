LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = " \
    git://github.com/TheYoctoJester/simple_echo_server.git;protocol=https;branch=master \
    file://simpleechoserver.service \
"

PV = "1.0+git${SRCPV}"
SRCREV = "670f02380fa00be3d2f83b597b2811052f1991ca"

S = "${WORKDIR}/git"

DEPENDS = "boost"

inherit cmake systemd

SYSTEMD_SERVICE:${PN} = "simpleechoserver.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    
    # CRITICAL FIX: Install AND substitute @BINDIR@ variable
    install -m 0644 ${WORKDIR}/simpleechoserver.service ${D}${systemd_system_unitdir}/
    sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_system_unitdir}/simpleechoserver.service
    
    # CRITICAL FIX: Manually create the wants symlink
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
    ln -sf ${systemd_system_unitdir}/simpleechoserver.service \
           ${D}${sysconfdir}/systemd/system/multi-user.target.wants/simpleechoserver.service
}

FILES:${PN} += "\
    ${systemd_system_unitdir}/simpleechoserver.service \
    ${sysconfdir}/systemd/system/multi-user.target.wants/simpleechoserver.service \
"
