**ZYBO Z7 – Yocto / PetaLinux Integration**

This repository documents a complete Yocto → PetaLinux → Zybo Z7-7010 workflow demonstrating how to build, package, and boot a custom Linux system on the Xilinx Zynq-7000 SoC.

🚀 Project Overview

This project integrates:

Yocto Project — to build a root filesystem and cross-compiled packages.

Xilinx PetaLinux — to package FSBL, U-Boot, FPGA bitstream, and boot image.

Zybo Z7-7010 FPGA board — as the target hardware.

Final output: a working BOOT.BIN + image.ub + rootfs that boots automatically from SD card.

🧩 Project Structure

yocto/          # Yocto build configuration
petalinux/      # PetaLinux project (hardware + software packaging)
docs/            # Boot logs, diagrams, serial output


1. Build Yocto Root Filesystem
cd ~/Desktop/YoctoSRC
source oe-init-build-env
bitbake zybo-image

⚙️ 2. Create PetaLinux Project and Import Hardware
petalinux-create -t project -n zybo_petalinux --template zynq
cd zybo_petalinux
petalinux-config --get-hw-description ~/.Xilinx/Vivado_Projects/zybo-Viv

🧰 3. Build PetaLinux
petalinux-build
Artifacts after build:
images/linux/zynq_fsbl.elf
images/linux/u-boot.elf
images/linux/system.dtb
images/linux/image.ub

🔧 4. Package Boot Image
petalinux-package boot \
  --fsbl images/linux/zynq_fsbl.elf \
  --u-boot \
  --fpga project-spec/hw-description/design_1_wrapper.bit

Generates:
images/linux/BOOT.BIN

and BOOT


