#!/bin/bash
display_help() {
    echo -e """
    ${CRED}TITLE${CE}
    ${CYELLOW}VERSION${CE}

    DESCRIPTION
    ${CORANGE}
    Usage:${CE} ${CRED}program ${CGREEN}[options]${CE} ${CBLUE}command${CE} ${CYELLOW}[args...]${CE}
    ${CGREEN}
    -a, --all               ${CE}Description about the all option.${CGREEN}
    -h, --human-readable    ${CE}Description about human-readable
    ${CBLUE}
    start                   ${CE}Description about the start command.
                            Spill over text goes on the second
                            or third line.${CBLUE}
    stop                    ${CE}Description about stop command.
    ${CYELLOW}
    arg1                    ${CE}Description about arg1 for command${CYELLOW}
    arg2                    ${CE}Description about arg2 for command
    ${CORANGE}
    Example(s):${CE}
        ${CRED}program ${CGREEN}--lazy-start ${CBLUE}start ${CYELLOW}--early-stop${CE}
    """
    exit 0
}
###############################################################################
#   FUNCTIONS
################################################################################
# Function: add_colors
# Author: Mike Abreu
# License: MIT
#
# This is a quick drop in function to add color variables to your scripting
# environment. You can call common colors by name like CRED for red text or
# you can call the direct number value as in C9 for red text. The same
# applies to backgrounds for example CBRED gives you a red background. You
# can chain these expressions for example:
# `echo -e "$C9$CB0Text to output$CE"`. This line will echo out our text in
# red text with a gray background.
#
# Legend:
# CE      = Color + End (Resets color)
# CCOLOR  = Color + Color Name
# C###    = Color + Color Number (Example: C202 = Orange)
# CBCOLOR = Color Background + Color Name
# CB###   = Color Background + Color Number (Example: CB9 = Red)
################################################################################
add_terminal_colors() {
    # Reset Color
    CE="\033[0m"
    # Text: Common Color Names
    CT="\033[38;5;"
    CRED="${CT}9m"
    CGREEN="${CT}28m"
    CBLUE="${CT}27m"
    CORANGE="${CT}202m"
    CYELLOW="${CT}226m"
    CPURPLE="${CT}53m"
    # Text: All Hex Values
    for HEX in {0..255};do eval "C$HEX"="\\\033[38\;5\;${HEX}m";done
    # Background: Common Color Names
    CB="\033[48;5;"
    CBRED="${CB}9m"
    CBGREEN="${CB}28m"
    CBBLUE="${CB}27m"
    CBORANGE="${CB}202m"
    CBYELLOW="${CB}226m"
    CBPURPLE="${CB}53m"
    # Background: All Hex Values
    for HEX in {0..255};do eval "CB${HEX}"="\\\033[48\;5\;${HEX}m";done
}
add_terminal_colors
################################################################################
# Lightweight Version
add_terminal_colors() {
    CE="\033[0m";
    CT="\033[38;5;";CRED="${CT}9m";CGREEN="${CT}28m";CBLUE="${CT}27m"
    CORANGE="${CT}202m";CYELLOW="${CT}226m";CPURPLE="${CT}53m"
    CB="\033[48;5;";CBRED="${CB}9m";CBGREEN="${CB}28m";CBBLUE="${CB}27m"
    CBORANGE="${CB}202m";CBYELLOW="${CB}226m";CBPURPLE="${CB}53m"
    for HEX in {0..255};do eval "C$HEX"="\\\033[38\;5\;${HEX}m";done
    for HEX in {0..255};do eval "CB${HEX}"="\\\033[48\;5\;${HEX}m";done
}
add_terminal_colors
################################################################################
################################################################################
# Function: display_help
# Author: Mike Abreu
# License: MIT
#
# TODO
################################################################################
display_help() {
    echo -e """
    ${CRED}TITLE${CE}
    ${CYELLOW}VERSION${CE}

    DESCRIPTION
    ${CORANGE}
    Usage:${CE} ${CRED}program ${CGREEN}[options]${CE} ${CBLUE}command${CE} ${CYELLOW}[args...]${CE}
    ${CGREEN}
    -a, --all               ${CE}Description about the all option.${CGREEN}
    -h, --human-readable    ${CE}Description about human-readable
    ${CBLUE}
    start                   ${CE}Description about the start command.
                            Spill over text goes on the second
                            or third line.${CBLUE}
    stop                    ${CE}Description about stop command.
    ${CYELLOW}
    arg1                    ${CE}Description about arg1 for command${CYELLOW}
    arg2                    ${CE}Description about arg2 for command
    ${CORANGE}
    Example(s):${CE}
        ${CRED}program ${CGREEN}--lazy-start ${CBLUE}start ${CYELLOW}--early-stop${CE}
    """
    exit 0
}
################################################################################
################################################################################
# Function: handle_arguments
# Author: Mike Abreu
# License: MIT
#
# TODO
################################################################################
# handle_arguments() {
#     if [[ -z $1 ]]; then
#         if display_help; then display_help fi
#         exit 1
#     fi
#     TEMP=`getopt -o t:h -l help,theme:,no-vim,no-font,no-grc -- "$@"`
#     if [[ $? != 0 ]]; then echo "Terminating." >&2 ; exit 1; fi
#     eval set -- "$TEMP"
#     while true; do
#         case "$1" in
#             -h | --help) display_help; shift ;;
#             -t | --theme) set_theme $2; shift 2 ;;
#             --no-vim) display_message $CBLUE "[+] Argument Accepted: VIM: Skipping VIM Configuration."
#                     vim=false; shift ;;
#             --no-font) display_message $CBLUE "[+] Argument Accepted: VIM: Skipping Font Configuration."
#                 font=false; shift ;;
#             --no-grc) display_message $CBLUE "[+] Argument Accepted: VIM: Skipping GRC Configuration."
#                 grc=false; shift ;;
#             -- ) shift; break ;;
#             *) break ;;
#         esac
#     done
# }
###############################################################################
################################################################################
# Function: get_ipv4
# Author: Mike Abreu
# License: MIT
#
# TODO
################################################################################
get_ipv4() {
    IP4=$(echo ${1} |grep -oE '(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)')
}
################################################################################
################################################################################
# Function: get_interface_ipv4
# Author: Mike Abreu
# License: MIT
#
# TODO
################################################################################
get_interface_ipv4() {
    local REG_IP4='(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)'
    # Check if any arguments were passed to the function.
    # If an argument is found, use the first one as the interface name.
    if [[ -z $1 ]]; then
        # Set the IP to eth0 ipv4 address.
        IP4=$(ifconfig eth0 |grep 'inet ' |grep -oE $REG_IP4 |awk '{print $1}' |head -1)
    else
        # Use the argument interface name.
        IP4=$(ifconfig $1 |grep 'inet ' |grep -oE $REG_IP4 |awk '{print $1}' |head -1)
    fi
}
################################################################################
# Lightweight Version
get_interface_ipv4() {
    local REG_IP4='(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)'
    if [[ -z $1 ]]; then
        IP4=$(ifconfig eth0 |grep 'inet ' |grep -oE $REG_IP4 |awk '{print $1}' |head -1)
    else
        IP4=$(ifconfig $1 |grep 'inet ' |grep -oE $REG_IP4 |awk '{print $1}' |head -1)
    fi
}
################################################################################
################################################################################
# Function: validate_ipv4
# Author: Mike Abreu
# License: MIT
#
# Syntax: validate_ipv4 <ipv4_addr> [public|private] [verbose]
#
# This function takes 1 argument and 2 optional fields. If passed only an ipv4
# address it will test if the address is valid from 0.0.0.0 - 255.255.255.255.
# If passed the public or private option along with an ipv4 addrress then it
# it will check the address against the respective class range. The verbose option
################################################################################
validate_ipv4() {
    if [[ ! -z $3 ]]; then verbose=true; else verbose=false; fi
    if [[ ! -z $2 ]]; then
        if [[ $2 == "public" ]]; then
            local REG_PUBLIC_IPV4_1='^(25[0-5]|2[0-4][0-9]|19[3-9]|19[0-1]|18[0-9]|17[3-9]|17[0-1]|1[0-6][0-9]|0?[2-9][0-9]|0?1[1-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])$'
            local REG_PUBLIC_IPV4_2='^(172)\.(1[0-5]|[0-9]|3[2-9]|[4-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])$'
            local REG_PUBLIC_IPV4_3='^(192)\.([0-9]?[0-9]|1[0-5][0-9]|16[0-7]|169|1[7-9][0-9]|2[0-4][0-9]|25[0-5])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])$'
            if [[ $1 =~ $REG_PUBLIC_IPV4_1 ]] || [[ $1 =~ $REG_PUBLIC_IPV4_2 ]] || [[ $1 =~ $REG_PUBLIC_IPV4_3 ]]; then
                if $verbose; then echo -e "${CGREEN}[+] Valid Public IPv4 Address: ${1}${CE}"; fi
                return 0
            else
                if $verbose; then echo -e "${CRED}[-] Invalid Public IPv4 Address: ${1}${CE}"; fi
                return 1
            fi
        elif [[ $2 == "private" ]]; then
            local REG_PRIVATE_IPV4_1='^(0?10)\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])$'
            local REG_PRIVATE_IPV4_2='^(172)\.(1[6-9]|[2-3][0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])$'
            local REG_PRIVATE_IPV4_3='^(192)\.(168)\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|0?[0-9][0-9]|0?0?[0-9])$'
            if [[ $1 =~ $REG_PRIVATE_IPV4_1 ]] || [[ $1 =~ $REG_PRIVATE_IPV4_2 ]] || [[ $1 =~ $REG_PRIVATE_IPV4_3 ]]; then
                if $verbose; then echo -e "${CGREEN}[+] Valid Private IPv4 Address: ${1}${CE}"; fi
                return 0
            else
                if $verbose; then echo -e "${CRED}[-] Invalid Private IPv4 Address: ${1}${CE}"; fi
                return 1
            fi
        fi
        exit 2
    else
        local REG_IPV4='(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)'
        if [[ $1 =~ $REG_IP4 ]]; then IP4=$1; else
            if $verbose; then echo -e "${CRED}[*] Invalid IPv4 address:${CE} $1"; fi
            return 1
        fi
    fi
    if $verbose; then echo -e "${CGREEN}[+] Valid IPv4 Address.${CE}"; fi
    return 0
}
################################################################################
################################################################################
# Function: confirmation_prompt
# Author: Mike Abreu
# License: MIT
#
# TODO
################################################################################
confirmation_prompt() {
    echo -en "${CYELLOW}Do you wish to continue? [Y/n] ${CE}"
    read -r response
    case $response in
        [nN][oO]|[nN])
            echo -e "${CORANGE}[*] Exiting by user request.${CE}"
            exit
            ;;
        *)
            false
            ;;
    esac
}
################################################################################
################################################################################
# Function: display_message
# Author: Mike Abreu
# License: MIT
#
# TODO
################################################################################
display_message() {
    echo -e "${1}${2}${CE}"
}
################################################################################
################################################################################
#   SCRIPT
################################################################################

echo -e """${CORANGE}
▄▄▄▄·  ▄▄▄· .▄▄ ·  ▄ .▄    ·▄▄▄▄• ▄▌ ▐ ▄  ▄▄· ▄▄▄▄▄▪         ▐ ▄ .▄▄ ·
▐█ ▀█▪▐█ ▀█ ▐█ ▀. ██▪▐█    ▐▄▄·█▪██▌•█▌▐█▐█ ▌▪•██  ██ ▪     •█▌▐█▐█ ▀.
▐█▀▀█▄▄█▀▀█ ▄▀▀▀█▄██▀▐█    ██▪ █▌▐█▌▐█▐▐▌██ ▄▄ ▐█.▪▐█· ▄█▀▄ ▐█▐▐▌▄▀▀▀█▄
██▄▪▐█▐█ ▪▐▌▐█▄▪▐███▌▐▀    ██▌.▐█▄█▌██▐█▌▐███▌ ▐█▌·▐█▌▐█▌.▐▌██▐█▌▐█▄▪▐█
·▀▀▀▀  ▀  ▀  ▀▀▀▀ ▀▀▀ ·    ▀▀▀  ▀▀▀ ▀▀ █▪·▀▀▀  ▀▀▀ ▀▀▀ ▀█▄▀▪▀▀ █▪ ▀▀▀▀
\n${CE}${CBLUE}    Table of Contents:${CE}\n${C226}
[1] add_terminal_colors
$CE        - Loads variables that contain all the color codes.
${C226}[2] get_ipv4 <search_query>
$CE        - Sets the variable IP4 to the found ipv4 address, if any.
${C226}[3] get_interface_ipv4 [interface=eth0]
$CE        - Sets the variable IP4 to the ipv4 of the desired interface.
${C226}[4] validate_ipv4 <user_input>
$CE        - Checks the input against the IPv4 Regex. Exits if false.
${C226}[5] confirmation_prompt
$CE        - Prompts the user if they want to continue. Exits on no.
${CE}"""
exit 0