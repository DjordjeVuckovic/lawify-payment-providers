package org.lawify.psp.mediator.subscriptionServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SubscriptionServiceRepository extends JpaRepository<SubscriptionServiceEntity, UUID> {
}
