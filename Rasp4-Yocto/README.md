# Minimal Yocto Linux Image for Raspberry Pi 4  
### Custom systemd-based distribution with a simple echo server

---

## 🧩 Project Overview
This project demonstrates the creation of a **custom embedded Linux distribution** for the **Raspberry Pi 4**, built using the **Yocto Project**.  


The image is designed to be minimal and systemd-managed, and includes a echo server service written in C, built with cmake that runs automatically at boot.

Contains:
- Layer and recipe creation in Yocto,
- Custom distribution configuration,
- Integration of a systemd service,
- Image composition and target deployment for Raspberry Pi 4.

---

## ⚙️ Key Features
- **Target:** Raspberry Pi 4 Model B  
- **Base:** Yocto Project (Scarthgap release)  
- **Init System:** `systemd`  
- **Custom Distribution:**  derived from Poky but with tailored features  
- **Custom Layer/Recipe**   
- **Network Service:** TCP Echo Server (runs on port 12345)  
- **Login:** Root console over serial  

---
