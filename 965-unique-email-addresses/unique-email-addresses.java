class Solution {

    public int numUniqueEmails(String[] emails) {

        HashSet<String> set = new HashSet<>();

        for(String email : emails) {

            int atIndex = email.indexOf('@');

            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            int plusIndex = local.indexOf('+');

            if(plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            local = local.replace(".", "");

            set.add(local + domain);
        }

        return set.size();
    }
}