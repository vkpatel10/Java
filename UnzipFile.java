import java.io.*;
import java.util.zip.*;
public class UnzipFile{
	private String zipPath,unzipPath;
	UnzipFile(String zipPath,String unzipPath){
		this.zipPath = zipPath;
		this.unzipPath = unzipPath;
	}
	
	public void extract(){
		File desDir;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ZipInputStream zis = null;
		ZipEntry ze;
		
		try{
			desDir = new File(unzipPath);
			if(!desDir.exists()){
				desDir.mkdir();
			}
			fis = new FileInputStream(zipPath);
			zis = new ZipInputStream(fis);
			ze = zis.getNextEntry();
			
			while(ze != null){
				String filePath = unzipPath + File.separator + ze.getName();
				
				if(!ze.isDirectory()){
					extractFile(zis,filePath);
				}
				else{
					File newDir = new File(filePath);
					newDir.mkdir();
				}
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			fis.close();
			zis.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void extractFile(ZipInputStream zis,String filePath){
		BufferedOutputStream bos = null;
		try{
			bos = new BufferedOutputStream( new FileOutputStream(filePath));
			byte bArr[] = new byte[1024];
			
			while(zis.read(bArr) != -1){
				bos.write(bArr);
			}
			bos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}