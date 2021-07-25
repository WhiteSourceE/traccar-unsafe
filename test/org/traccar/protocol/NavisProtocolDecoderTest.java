package org.traccar.protocol;

import org.traccar.ProtocolTest;

import org.junit.Test;

public class NavisProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        NavisProtocolDecoder decoder = new NavisProtocolDecoder(new NavisProtocol());

        verifyNull(decoder, binary(
                "404E5443010000007B000000130044342A3E533A383631373835303035323035303739"));

        verifyPosition(decoder, binary(
                "404e5443010000000000000059009adb2a3e54250000000000ff1500040b0a1008291838001200760ee600000000000000000000000f1500040b0a10ac20703fb1aec23f00000000320149668f430000000000000000000000000000000000000000000000f3808080"),
                position("2016-11-11 21:00:04.000", true, 53.74336, 87.14437));

        verifyPositions(decoder, binary(
                "404e544300000000040000005a00c6812a3e410125e3a60700011705071503011030210c0000fa200910e6000000000000000000000001082106150010ae97643f88a39f3f0000000090001fcc6c450000000000000000000000000000000000000000000000f6808080"));

        verifyPositions(decoder, binary(
                "404e544301000000000000005a002e6c2a3e410125d7540100001512233a0b0a0f08026300000a000b000b00020000000000000000000c12233b0b0a0f03fd6d3f0fde603f00000000ba0051e0c845000000000000000000000000000000000000000000000080808080"));

        verifyPositions(decoder, binary(
                "404E5443010000007B0000005A0050692A3E410125DB0E00000015110707110A0C0880630000AA39A2381600020000000000000000000C110708110A0CB389793F1AEF263F00000000120034F516440000000000000000000000FAFF000000FAFF000000FAFF80808080"));

        verifyNull(decoder, binary(
                "404E5443010000007B000000130047372A3E533A383631373835303035313236303639"));

    }

}
