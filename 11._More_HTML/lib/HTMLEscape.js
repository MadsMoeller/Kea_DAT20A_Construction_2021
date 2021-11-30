function escapeHTML(string) {
    console.log(string)
    if(!string) return "";
    string = string.replaceAll(/&/g, "&amp;");
    string = string.replaceAll(/>/g, "&gt;");
    string = string.replaceAll(/</g, "&lt;");
    string = string.replaceAll(/"/g, "&quot;");
    string = string.replaceAll(/'/g, "&#039;");
    return string;
}