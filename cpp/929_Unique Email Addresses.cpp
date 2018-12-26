/*
 字符串处理，记忆一下C++中处理字符串的函数
 */
class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        unordered_set<string> names;
        for (auto &email : emails) {
            auto first_at = email.find('@');
            if (first_at < email.size()) {
                string local_name = email.substr(0, first_at);
                string domain_name = email.substr(first_at + 1);
                auto first_plus = local_name.find('+');
                local_name = local_name.substr(0, first_plus);                
                local_name.erase(
                    std::remove(local_name.begin(), local_name.end(), '.'),
                    local_name.end()
                );
                names.insert(local_name + "@" + domain_name);
            }
        }
        return names.size();
    }
};