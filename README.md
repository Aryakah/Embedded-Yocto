This repository contains two separate embedded Linux projects targeting different hardware platforms:

Projects
**1. Raspberry Pi 4 – Minimal Yocto Linux**

Description: A minimal Yocto-based Linux image with systemd and a simple TCP echo server.

Folder: Rasp4-Yocto

Highlights:

Custom Yocto layer and recipe creation

Minimal systemd-based distribution

TCP echo server running on boot

Root console over serial

**2. Zybo Z7-7010 – Yocto / PetaLinux Integration**

Description: Workflow integrating Yocto and PetaLinux to build a custom Linux system for the Zybo Z7 FPGA board.

Folder: Zynq_FPGA_Zybo-z7-7010

Highlights:

Yocto root filesystem and cross-compiled packages

PetaLinux packaging of FSBL, U-Boot, FPGA bitstream, and boot image

Automatic boot from SD card
