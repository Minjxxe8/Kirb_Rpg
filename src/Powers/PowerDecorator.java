package Powers;

import Core.Entity;

public abstract class PowerDecorator implements Power {

    protected final Power wrapped;

    public PowerDecorator(Power wrapped) {
        this.wrapped = wrapped;
    }

    @Override public String getName()               { return wrapped.getName(); }
    @Override public int getDamage()                { return wrapped.getDamage(); }
    @Override public void executeAction(Entity t)  { wrapped.executeAction(t); }
    @Override public PowersEnum getType()           { return wrapped.getType(); }
    @Override public PowersEnum getStrongAgainst()  { return wrapped.getStrongAgainst(); }
    @Override public PowersEnum getWeakAgainst()    { return wrapped.getWeakAgainst(); }
}