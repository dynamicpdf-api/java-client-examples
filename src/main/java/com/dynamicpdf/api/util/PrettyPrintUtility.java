package com.dynamicpdf.api.util;



public class PrettyPrintUtility {

	public static String DividerLine() {
		return "==========================================================================="; 
	}
	
	/**
	 * A simple implementation to pretty-print JSON file.
	 *
	 * @param unformattedJsonString
	 * @return
	 */
	public static String prettyPrintJSON(String unformattedJsonString) {
	  StringBuilder prettyJSONBuilder = new StringBuilder();
	  int indentLevel = 0;
	  boolean inQuote = false;
	  for(char charFromUnformattedJson : unformattedJsonString.toCharArray()) {
	    switch(charFromUnformattedJson) {
	      case '"':
	        // switch the quoting status
	        inQuote = !inQuote;
	        prettyJSONBuilder.append(charFromUnformattedJson);
	        break;
	      case ' ':
	        // For space: ignore the space if it is not being quoted.
	        if(inQuote) {
	          prettyJSONBuilder.append(charFromUnformattedJson);
	        }
	        break;
	      case '{':
	      case '[':
	          if(inQuote) {
	              prettyJSONBuilder.append(charFromUnformattedJson);
	            } 
	          else {
	        // Starting a new block: increase the indent level
	        prettyJSONBuilder.append(charFromUnformattedJson);
	        indentLevel++;
	        appendIndentedNewLine(indentLevel, prettyJSONBuilder);
	          }
	        break;
	      case '}':
	      case ']':
	          if(inQuote) {
	              prettyJSONBuilder.append(charFromUnformattedJson);
	            } else {
	        indentLevel--;
	        appendIndentedNewLine(indentLevel, prettyJSONBuilder);
	        prettyJSONBuilder.append(charFromUnformattedJson);
	            }
	        break;
	      case ',':
	        // Ending a json item; create a new line after
	        prettyJSONBuilder.append(charFromUnformattedJson);
	        if(!inQuote) {
	          appendIndentedNewLine(indentLevel, prettyJSONBuilder);
	        }
	        break;
	      default:
	        prettyJSONBuilder.append(charFromUnformattedJson);
	    }
	  }
	  return prettyJSONBuilder.toString();
	}

	/**
	 * Print a new line with indention at the beginning of the new line.
	 * @param indentLevel
	 * @param stringBuilder
	 */
	private static void appendIndentedNewLine(int indentLevel, StringBuilder stringBuilder) {
	  stringBuilder.append("\n");
	  for(int i = 0; i < indentLevel; i++) {
	    // Assuming indention using 2 spaces
	    stringBuilder.append("  ");
	  }
	}
	
}
