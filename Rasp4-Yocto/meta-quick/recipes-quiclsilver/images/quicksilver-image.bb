require recipes-core/images/core-image-minimal.bb

DESCRIPTION = "A small image just capable of \
runnig echo server"

IMAGE_FEATURES += "dev-pkgs"
IMAGE_INSTALL:append = " simpleecho-server screen"

