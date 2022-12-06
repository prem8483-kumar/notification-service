package com.meesho.notification.services.blacklist;
import com.meesho.notification.requests.blacklist.BlacklistRequestBody;

public interface BlacklistService {

    public void addNumbersToBlacklist(BlacklistRequestBody blacklistRequestBody);

    public void getBlacklistedNumbers();

    public void removeNumbersFromBlacklist(BlacklistRequestBody blacklistRequestBody);
}
