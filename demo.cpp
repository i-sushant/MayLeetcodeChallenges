#include <iostream>
#include <string>
using namespace std;
bool checkinclusion(string s1, string s2)
{
    if (s2.length() == 0) {
        return false;
    }
    int freq[26];
    for (auto x : s1) {
        freq[x - 'a']++;
    }
    int i = 0, j = 0, count = 0;
    while (j < s2.length()) {
        if (freq[s2[j++] - 'a'] > 0) {
            count--;
        }
        if (count == 0) {
            return true;
        }
        if (j - i == s1.length() && freq[s2[i++] - 'a']++ >= 0) {
            count++;
        }
    }
    return false;
}