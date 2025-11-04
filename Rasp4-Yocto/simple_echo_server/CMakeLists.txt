cmake_minimum_required(VERSION 3.1)
project(simpleecho_server)

find_package(Boost REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

set(THREADS_PREFER_PTHREAD_FLAG ON)
find_package(Threads REQUIRED)

add_executable(simple_echo_server main.cpp)
target_link_libraries(simple_echo_server PRIVATE Threads::Threads)

install(TARGETS simple_echo_server DESTINATION bin)
