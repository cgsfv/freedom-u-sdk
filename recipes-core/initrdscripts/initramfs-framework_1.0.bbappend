FILESEXTRAPATHS_prepend := "${THISDIR}/initramfs-framework:"

SRC_URI += " \
           file://nbdrootfs \
          "

do_install_append() {

    # base
    install -m 0755 ${WORKDIR}/nbdrootfs ${D}/init.d/86-nbdrootfs
}

PACKAGES += " \
            initramfs-module-nbdrootfs \
           "


SUMMARY_initramfs-module-nbdrootfs = "initramfs support for locating and mounting the root partition via nbd"
RDEPENDS_initramfs-module-nbdrootfs = "${PN}-base"
FILES_initramfs-module-nbdrootfs = "/init.d/86-nbdrootfs"

