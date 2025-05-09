package management;

import library.Member;
import library.Transaction;
import datastructures.maps.CustomHashMap;

public class MemberManager {
    private CustomHashMap<String, Member> membersById;

    public MemberManager() {
        this.membersById = new CustomHashMap<>();
    }
    public void addMember(Member member) {
        if (member == null || member.getMemberId() == null) {
            throw new IllegalArgumentException("Member or memberId cannot be null");
        }
        membersById.put(member.getMemberId(), member);
    }
    public Member getMember(String memberId) {
        if (memberId == null) {
            throw new IllegalArgumentException("Member ID cannot be null");
        }
        return membersById.get(memberId);
    }
    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = getMember(memberId);
        if (member != null && transaction != null) {
            member.addTransaction(transaction);
        } else {
            throw new IllegalArgumentException("Member or transaction cannot be null");
        }
    }
    public Transaction getLastTransaction(String memberId) {
        Member member = getMember(memberId);
        if (member != null) {
            return member.getLastTransaction();
        }
        return null;
    }
}
