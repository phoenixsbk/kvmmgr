/* Generated By:JavaCC: Do not edit this line. OsInfoParser.java */
package org.ovirt.engine.core.utils.osinfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.StringReader;

public class OsInfoParser implements OsInfoParserConstants {

  final public void parse() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OS:
      case BACKWARDCOMPATIBILITY:
      case LINECOMMENT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OS:
        osRecord();
        break;
      case BACKWARDCOMPATIBILITY:
        compatibilityRecord();
        break;
      case LINECOMMENT:
        comment();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EOL:
        jj_consume_token(EOL);
        break;
      case 0:
        jj_consume_token(0);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void osRecord() throws ParseException {
    jj_consume_token(OS);
    jj_consume_token(DOT);
    jj_consume_token(OS_UNIQUE_NAME);
    jj_consume_token(DOT);
    attribute();
  }

  final public void compatibilityRecord() throws ParseException {
    jj_consume_token(BACKWARDCOMPATIBILITY);
    jj_consume_token(DOT);
    jj_consume_token(OS_UNIQUE_NAME);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WS:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(WS);
    }
    jj_consume_token(EQUALS);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WS:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      jj_consume_token(WS);
    }
    jj_consume_token(INT);
  }

  final public void comment() throws ParseException {
    jj_consume_token(LINECOMMENT);
  }

  final public void attribute() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      intValue();
      break;
    case NAME:
      jj_consume_token(NAME);
      stringValue();
      break;
    case DESCRIPTION:
      jj_consume_token(DESCRIPTION);
      stringValue();
      break;
    case DERIVED_FROM:
      jj_consume_token(DERIVED_FROM);
      stringValue();
      break;
    case FAMILY:
      jj_consume_token(FAMILY);
      stringValue();
      break;
    case 1:
      jj_consume_token(1);
      archValue();
      break;
    case CPU_UNSUPPORTED:
      jj_consume_token(CPU_UNSUPPORTED);
      stringValue();
      break;
    case 2:
      jj_consume_token(2);
      busValue();
      break;
    case SYSPREP_PATH:
      jj_consume_token(SYSPREP_PATH);
      stringValue();
      break;
    case SYSPREP_FILENAME:
      jj_consume_token(SYSPREP_FILENAME);
      stringValue();
      break;
    case PRODUCT_KEY:
      jj_consume_token(PRODUCT_KEY);
      stringValue();
      break;
    case 3:
      jj_consume_token(3);
      booleanValue();
      break;
    case 4:
      resources();
      break;
    case 10:
      devices();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void resources() throws ParseException {
    jj_consume_token(4);
    jj_consume_token(DOT);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 5:
        jj_consume_token(5);
        jj_consume_token(DOT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 6:
          jj_consume_token(6);
          break;
        case 7:
          jj_consume_token(7);
          break;
        case 8:
          jj_consume_token(8);
          break;
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        intValue();
        break;
      case 9:
        jj_consume_token(9);
        jj_consume_token(DOT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 6:
          jj_consume_token(6);
          break;
        case 7:
          jj_consume_token(7);
          break;
        case 8:
          jj_consume_token(8);
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        intValue();
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 5:
      case 9:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_4;
      }
    }
  }

  final public void devices() throws ParseException {
    jj_consume_token(10);
    jj_consume_token(DOT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 11:
      jj_consume_token(11);
      displayValue();
      break;
    case 12:
      jj_consume_token(12);
      watchdogValue();
      break;
    case 13:
      jj_consume_token(13);
      networkValue();
      break;
    case 14:
      jj_consume_token(14);
      booleanValue();
      break;
    case 15:
      jj_consume_token(15);
      hardwareInterfacesValue();
      break;
    case 16:
      jj_consume_token(16);
      booleanValue();
      break;
    case 17:
      jj_consume_token(17);
      audioValue();
      break;
    case 18:
      jj_consume_token(18);
      cdInterfaceValue();
      break;
    case 19:
      jj_consume_token(19);
      hardwareInterfacesValue();
      break;
    case 20:
      jj_consume_token(20);
      intValue();
      break;
    case 21:
      jj_consume_token(21);
      booleanValue();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void intValue() throws ParseException {
    valueSpecifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case BUS_WIDTH:
      jj_consume_token(BUS_WIDTH);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void stringValue() throws ParseException {
    jj_consume_token(VALUE);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOT:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_5;
      }
      jj_consume_token(DOT);
      jj_consume_token(VERSION);
    }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WS:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
      jj_consume_token(WS);
    }
    jj_consume_token(EQUALS_STR);
  }

  final public void booleanValue() throws ParseException {
    valueSpecifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 22:
      jj_consume_token(22);
      break;
    case 23:
      jj_consume_token(23);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void archValue() throws ParseException {
    valueSpecifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 24:
      jj_consume_token(24);
      break;
    case 25:
      jj_consume_token(25);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void busValue() throws ParseException {
    valueSpecifier();
    jj_consume_token(BUS_WIDTH);
  }

  final public void displayValue() throws ParseException {
    valueSpecifier();
    jj_consume_token(DISPLAY_PROTOCOL_TYPE);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_7;
      }
      jj_consume_token(COMMA);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case WS:
          ;
          break;
        default:
          jj_la1[17] = jj_gen;
          break label_8;
        }
        jj_consume_token(WS);
      }
      jj_consume_token(DISPLAY_PROTOCOL_TYPE);
    }
  }

  final public void watchdogValue() throws ParseException {
    valueSpecifier();
    jj_consume_token(26);
  }

  final public void networkValue() throws ParseException {
    valueSpecifier();
    jj_consume_token(NETWORK_DEVICE_TYPE);
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_9;
      }
      jj_consume_token(COMMA);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case WS:
          ;
          break;
        default:
          jj_la1[19] = jj_gen;
          break label_10;
        }
        jj_consume_token(WS);
      }
      jj_consume_token(NETWORK_DEVICE_TYPE);
    }
  }

  final public void audioValue() throws ParseException {
    valueSpecifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 27:
      jj_consume_token(27);
      break;
    case 28:
      jj_consume_token(28);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void cdInterfaceValue() throws ParseException {
    valueSpecifier();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      jj_consume_token(29);
      break;
    case 30:
      jj_consume_token(30);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void hardwareInterfacesValue() throws ParseException {
    valueSpecifier();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case HARDWARE_INTERFACE_TYPE:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_11;
      }
      jj_consume_token(HARDWARE_INTERFACE_TYPE);
    }
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[23] = jj_gen;
        break label_12;
      }
      jj_consume_token(COMMA);
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case WS:
          ;
          break;
        default:
          jj_la1[24] = jj_gen;
          break label_13;
        }
        jj_consume_token(WS);
      }
      jj_consume_token(HARDWARE_INTERFACE_TYPE);
    }
  }

  final public void valueSpecifier() throws ParseException {
    jj_consume_token(VALUE);
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOT:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_14;
      }
      jj_consume_token(DOT);
      jj_consume_token(VERSION);
    }
    label_15:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WS:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_15;
      }
      jj_consume_token(WS);
    }
    jj_consume_token(EQUALS);
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WS:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_16;
      }
      jj_consume_token(WS);
    }
  }

  /** Generated Token Manager. */
  public OsInfoParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x1,0x0,0x0,0x41e,0x1c0,0x1c0,0x220,0x220,0x3ff800,0x0,0x0,0x0,0xc00000,0x3000000,0x0,0x0,0x0,0x0,0x18000000,0x60000000,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x20030000,0x20030000,0x20,0x4,0x4,0x7fc0000,0x0,0x0,0x0,0x0,0x0,0x6000,0x1,0x4,0x0,0x0,0x80,0x4,0x80,0x4,0x0,0x0,0x200,0x80,0x4,0x1,0x4,0x4,};
   }

  /** Constructor with InputStream. */
  public OsInfoParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public OsInfoParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new OsInfoParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public OsInfoParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new OsInfoParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public OsInfoParser(OsInfoParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(OsInfoParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[62];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 62; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
