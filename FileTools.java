package botpackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * FileTool is a class which provides some methods used to work on Files and Folders.
 */
public final class FileTools {
 
	/**
	 * FileTools Constructor.
	 */
	public FileTools() {
	}
 
	/**
	 * Check if a specified file path is a folder and create a folder if it does
	 * not exist.
	 * 
	 * @param folderPath A folder path.
	 * @param logger A logger.
	 */
	public static void checkFolder(String folderPath) {
		File file = new File(folderPath);
		if (!(file.isDirectory())) {
			file.mkdir();
	
		}
	}
 
	/**
	 * Delete a directory.
	 * 
	 * @param path A folder path.
	 * @param logger A logger.
	 */
	public static void deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
					
				}
			}
		}
		path.delete();
		
	}
 
	/**
	 * Move a file from a source to a destination. If the moving by using the
	 * renameTo method does not work, it used the copy method.
	 * 
	 * @param src Source file path.
	 * @param dst Destination file path.
	 * @param logger A logger.
	 */
	public static void move(String src, String dst) {
		File source = new File(src);
		File destination = new File(dst);
		// Try to use renameTo
		boolean result = source.renameTo(destination);
		if (!result) {
			// Copy
			copy(src, dst);
		} else {
		
		}
	}
 
	/**
	 * Copy a file from a source to a destination.
	 * 
	 * @param src Source file path.
	 * @param dst Destination file path.
	 * @param logger A logger.
	 */
	public static void copy(String src, String dst) {
	
		File source = new File(src);
		File destination = new File(dst);
		FileInputStream sourceFile = null;
		FileOutputStream destinationFile = null;
		try {
			destination.createNewFile();
			sourceFile = new FileInputStream(source);
			destinationFile = new java.io.FileOutputStream(destination);
			// Read by 0.5MB segment.
			byte buffer[] = new byte[512 * 1024];
			int nbRead;
			while ((nbRead = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbRead);
			}
			sourceFile.close();
			destinationFile.close();
		} catch (Exception e) {
			
		}
	}
 
	/**
	 * Copy all files and directories from a Folder to a destination Folder.
	 * Must be called like: listAllFilesInFolder(srcFolderPath, "", srcFolderPath,
	 * destFolderPath)
	 * 
	 * @param currentFolder Used for the recursive called.
	 * @param relatedPath Used for the recursive called.
	 * @param sourceFolder Source directory.
	 * @param destinationFolder Destination directory.
	 * @param logger A logger.
	 */
	public static void copyFolderToFolder(String currentFolder,
			String relatedPath, String sourceFolder, String destinationFolder
			) {
		// Current Directory.
		
		File current = new File(currentFolder);
		if (current.isDirectory()) {
			// List all files and folder in the current directory.
			File[] list = current.listFiles();
			if (list != null) {
				// Read the files list.
				for (int i = 0; i < list.length; i++) {
					// Create current source File
					File tf = new File(sourceFolder + relatedPath + "\\"
							+ list[i].getName());
					// Create current destination File
					File pf = new File(destinationFolder + relatedPath + "\\"
							+ list[i].getName());
					if (tf.isDirectory() && !pf.exists()) {
						// If the file is a directory and does not exit in the
						// destination Folder.
						
						// Create the directory.
						pf.mkdir();
						copyFolderToFolder(tf.getAbsolutePath(), relatedPath
								+ "\\" + tf.getName(), sourceFolder,
								destinationFolder);
					} else if (tf.isDirectory() && pf.exists()) {
						// If the file is a directory and exits in the
						// destination Folder.
						copyFolderToFolder(tf.getAbsolutePath(), relatedPath
								+ "\\" + tf.getName(), sourceFolder,
								destinationFolder);
					} else if (tf.isFile()) {
						// If it is a file.
						
						copy(sourceFolder + relatedPath + "\\"
								+ list[i].getName(), destinationFolder
								+ relatedPath + "\\" + list[i].getName());
					} else {
						// Other cases.
						
					}
				}
			}
		}
	}
 
	/**
	 * Remove a Vector of files on the local machine.
	 * 
	 * @param files A vector of file paths.
	 * @param projectDirectory The project Directory.
	 * @param logger A logger.
	 */
	public static void removeFiles(Vector<String> files,
			String projectDirectory) {
		Iterator<String> it = files.iterator();
		
		while (it.hasNext()) {
			removeFile(it.next(), projectDirectory);
		}
	}
 
	/**
	 * Remove a file in a specified root directory.
	 * 
	 * @param file A file path.
	 * @param rootDirectory A root directory.
	 * @param logger A logger.
	 */
	public static void removeFile(String file, String rootDirectory) {
		// Remove a file on the local machine
		if (file.equalsIgnoreCase("") || file == null) {
		
		}
		File dir = new File(rootDirectory);
		if (!dir.isDirectory()) {
			
		} else {
			String filename;
			if (rootDirectory.charAt(rootDirectory.length() - 1) == '/') {
				filename = rootDirectory + file;
			} else {
				filename = rootDirectory + "/" + file;
			}
			File f = new File(filename);
			if (f.exists()) {
				f.delete();
				
			} else {
				
			}
		}
	}
}