#include <iostream>
using namespace std;

void printAllSubsequences(string str, string newStr) {
    // Base Case: If the original string is empty, print the collected subsequence
    if (str.empty()) {
        cout << "\"" << newStr << "\"" << endl;  // Print with quotes to show empty case
        return;
    }

    // Pick the first character
    char ch = str[0];

    // Reduce the string for recursion
    string restOfString = str.substr(1);

    // Include character in subsequence
    printAllSubsequences(restOfString, newStr + ch);

    // Exclude character from subsequence
    printAllSubsequences(restOfString, newStr);
}

int main() {
    string str = "ab";
    cout << "All Subsequences of \"" << str << "\":" << endl;
    printAllSubsequences(str, "");
    return 0;
}
