        // MESSAGE DATA32 PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        //import android.util.Log;
        
        /**
        * Data packet, size 32
        */
        public class msg_data32 extends MAVLinkMessage{
        
        public static final int MAVLINK_MSG_ID_DATA32 = 170;
        public static final int MAVLINK_MSG_LENGTH = 34;
        private static final long serialVersionUID = MAVLINK_MSG_ID_DATA32;
        
        
         	/**
        * data type
        */
        public byte type;
         	/**
        * data length
        */
        public byte len;
         	/**
        * raw data
        */
        public byte data[] = new byte[32];
        
        
        /**
        * Generates the payload for a mavlink message for a message of this type
        * @return
        */
        public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_DATA32;
        		packet.payload.putByte(type);
        		packet.payload.putByte(len);
        		 for (int i = 0; i < data.length; i++) {
                    packet.payload.putByte(data[i]);
                    }
        
		return packet;
        }
        
        /**
        * Decode a data32 message into this class fields
        *
        * @param payload The message to decode
        */
        public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        	    this.type = payload.getByte();
        	    this.len = payload.getByte();
        	     for (int i = 0; i < this.data.length; i++) {
                    this.data[i] = payload.getByte();
                    }
        
        }
        
        /**
        * Constructor for a new message, just initializes the msgid
        */
        public msg_data32(){
    	msgid = MAVLINK_MSG_ID_DATA32;
        }
        
        /**
        * Constructor for a new message, initializes the message with the payload
        * from a mavlink packet
        *
        */
        public msg_data32(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_DATA32;
        unpack(mavLinkPacket.payload);
        //Log.d("MAVLink", "DATA32");
        //Log.d("MAVLINK_MSG_ID_DATA32", toString());
        }
        
              
        /**
        * Returns a string with the MSG name and data
        */
        public String toString(){
    	return "MAVLINK_MSG_ID_DATA32 -"+" type:"+type+" len:"+len+" data:"+data+"";
        }
        }
        