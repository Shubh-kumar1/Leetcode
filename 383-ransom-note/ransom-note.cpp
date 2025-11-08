class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char,int> mpp1;
        unordered_map<char,int> mpp2;
        for(char& c:ransomNote){
            mpp1[c]++;
        }
        for(char& c:magazine){
            mpp2[c]++;
        }
        for(auto const& [key,val]: mpp1){
            if(mpp2[key]<val){
                return false;
            }
        }
        return true;
    }
};