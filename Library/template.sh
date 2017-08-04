#!/bin/bash
# Author: Mike Abreu
################################################################################
main() {
    clear
    display_info "This repository is a compilation of code that I've wrote."
    script_confirmation
}
################################################################################

################################################################################
display_info() {
    echo
    display_bar $CBLUE
    echo -e "${CBLUE}[*]${CE} ${1}${CE}"
    display_bar $CBLUE
}
display_message() {
    echo -e "${CGREEN}[+]${CE} ${1}${CE}"
}
display_success() {
    echo
    display_bar $CGREEN
    echo -e "${CGREEN}[+]${CE} ${1}${CE}"
    display_bar $CGREEN
}
display_warning() {
    echo
    display_bar $CYELLOW
    echo -e "${CYELLOW}[!]${CE} ${1}${CE}"
    display_bar $CYELLOW
}
display_error() {
    echo
    display_bar $CRED
    echo -e "${CRED}[-]${CE} ${1}${CE}"
    display_bar $CRED
}
display_bar() {
    echo -e "${1}====================================================================================================${CE}"
}
prompt_confirmation() {
    echo
    echo -en "${CYELLOW}[!]${CE} $1  ${CYELLOW}${2}${CE}  "
    read -r response
    case $response in
        [yY]|[yY][eE][sS])
            false
            ;;
        *)
            exit 1
            ;;
    esac
}
script_confirmation() {
    display_bar $CYELLOW
    echo -e "${CYELLOW}[!]${CE} This script will install software to your operating system and change configurations.${CE}"
    echo
    echo -e "    For a full list of software and configuration changes see ${CBLUE}https://github.com/mikeabreu/tconfig${CE}"
    echo
    echo -e "    ${CRED}CTRL+C to exit the script during execution.${CE}"
    display_bar $CYELLOW
    prompt_confirmation "Are you sure that you wish to continue?" "[y/N]"
}
################################################################################
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
main $@