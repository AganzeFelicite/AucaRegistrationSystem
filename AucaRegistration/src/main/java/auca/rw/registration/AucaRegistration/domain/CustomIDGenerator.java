package auca.rw.registration.AucaRegistration.domain;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIDGenerator implements IdentifierGenerator {
    private static int nextValue = 3000;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Generate a 4-digit ID starting from 1000 and incrementing by 1
        int id = nextValue;
        nextValue++;
        return id;
    }
}
