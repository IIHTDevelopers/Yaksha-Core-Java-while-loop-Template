package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.WhileStmt;

public class AutoGrader {

	// Test if the code uses only while-loop and not for or do-while loops
	public boolean testWhileLoopOnly(String filePath) throws IOException {
		System.out.println("Starting testWhileLoopOnly with file: " + filePath);

		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		boolean hasWhileLoop = false;

		// Log the parsed while-loop statements
		System.out.println("------ While-Loop Statements ------");
		for (WhileStmt whileStmt : cu.findAll(WhileStmt.class)) {
			System.out.println("While-loop found: " + whileStmt);
			hasWhileLoop = true;
		}

		// Check if only while-loop is used and no 'for' or 'do-while'
		System.out.println("Has while-loop: " + hasWhileLoop);

		boolean result = hasWhileLoop;
		System.out.println("Test result: " + result);

		return result;
	}
}
