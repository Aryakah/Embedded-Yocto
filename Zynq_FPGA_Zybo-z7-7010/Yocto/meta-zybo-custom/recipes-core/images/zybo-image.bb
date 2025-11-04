require recipes-core/images/core-image-minimal.bb

DESCRIPTION = "A small image just capable of \
runnig booting Zybo"

IMAGE_FEATURES:append = " ssh-server-dropbear debug-tweaks"

IMAGE_INSTALL:append = " screen vim ethtool bc"

