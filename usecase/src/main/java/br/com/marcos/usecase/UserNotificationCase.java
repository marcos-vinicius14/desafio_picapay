package br.com.marcos.usecase;

import br.marcos.core.domain.Transaction;

public interface UserNotificationCase {
    Boolean notificate(Transaction transaction, String email);
}
