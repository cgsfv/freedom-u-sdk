SUMMARY = "System load testing utility"
DESCRIPTION = "Deliberately simple workload generator for POSIX systems. It \
imposes a configurable amount of CPU, memory, I/O, and disk stress on the system."
HOMEPAGE = "https://kernel.ubuntu.com/~cking/stress-ng/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "V0.13.05"
S = "${WORKDIR}/git"
PV .= "+git${SRCPV}"

SRC_URI = "git://github.com/ColinIanKing/stress-ng \
           file://0001-Do-not-preserve-ownership-when-installing-example-jo.patch \
           "

DEPENDS = "coreutils-native zlib libaio libbsd attr libcap libgcrypt keyutils lksctp-tools"

PROVIDES = "stress"
RPROVIDES:${PN} = "stress"
RREPLACES:${PN} = "stress"
RCONFLICTS:${PN} = "stress"

inherit bash-completion

do_install() {
    oe_runmake DESTDIR=${D} install
    ln -s stress-ng ${D}${bindir}/stress
}

