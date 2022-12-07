package com.meesho.notification.services.blacklist;
import com.meesho.notification.models.requests.blacklist.BlacklistRequestBody;
import com.meesho.notification.models.response.blacklist.AddNumberToBlacklistResponse;
import com.meesho.notification.models.response.blacklist.GetBlacklistedNumbersResponse;
import com.meesho.notification.models.response.blacklist.RemoveNumberFromBlacklistResponse;

public interface BlacklistService {

    public AddNumberToBlacklistResponse addNumbersToBlacklist(BlacklistRequestBody blacklistRequestBody);

    public GetBlacklistedNumbersResponse getBlacklistedNumbers();

    public RemoveNumberFromBlacklistResponse removeNumbersFromBlacklist(BlacklistRequestBody blacklistRequestBody);
}
