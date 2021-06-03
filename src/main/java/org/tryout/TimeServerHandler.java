package org.tryout;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;

public class TimeServerHandler implements IoHandler {

    @Override
    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception
    {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception
    {
        String str = message.toString();
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close();
            return;
        }

        Date date = new Date();
        session.write( date.toString() );
        System.out.println("Message written...");
    }

    @Override
    public void messageSent(IoSession ioSession, Object o) throws Exception {
        System.out.println("messageSent");
    }

    @Override
    public void inputClosed(IoSession ioSession) throws Exception {
        System.out.println("inputClosed");
    }

    @Override
    public void event(IoSession ioSession, FilterEvent filterEvent) throws Exception {
        System.out.println("event");
    }

    @Override
    public void sessionCreated(IoSession ioSession) throws Exception {
        System.out.println("sessionCreated");
    }

    @Override
    public void sessionOpened(IoSession ioSession) throws Exception {
        System.out.println("sessionOpened");
    }

    @Override
    public void sessionClosed(IoSession ioSession) throws Exception {
        System.out.println("sessionClosed");
    }

    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception
    {
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }
}
