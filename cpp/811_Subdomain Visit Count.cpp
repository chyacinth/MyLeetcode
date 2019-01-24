/**
 * Simple
 **/
class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        unordered_map<string, int> domain_count;
        istringstream is;
        for (string & cpdomain : cpdomains) {
            is.clear();
            is.str(cpdomain);
            int count = 0;
            is >> count;
            string domain;
            is >> domain;
            int length = domain.size();
            domain_count[domain] += count;
            for (int i = length - 1; i >= 0; --i) {
                if (domain[i] == '.') {
                    domain_count[domain.substr(i + 1, length - i - 1)] += count;
                }
            }
        }
        vector<string> result;
        for (auto &pair : domain_count) {
            result.push_back(to_string(pair.second) + " " + pair.first);
        }
        return result;
    }
};