<?php

    $logger = "";
    $gif_width = "150";
    $gif_height = "150";
    $thumbnail_size = "400x400";
    $interval = 5;
    $thumbnail_image_name = "thumb.png";
    $watermarkPath = "assets/images/logo.png";  // you can change the logo for watermark  recommended size is 100x31px
    $videoPageTitle="Your App Name Here";

    $ffmpeg_lib="video_editor/ffmpeg/ffmpeg";    // eg.  /usr/bin/ffmpeg
    $ffprobe_lib="video_editor/ffmpeg/ffprobe"; //eg.   /usr/bin/ffprobe


    //web API path
	//eg http://domain.com/API/
	$API_path="http://192.168.225.34/API/";
	define("API_path",$API_path);
	define("ffmpeg_lib",$ffmpeg_lib);
    define("ffprobe_lib",$ffprobe_lib);
    define("watermark_Path",$watermarkPath);
    define("view_page_title",$videoPageTitle);

	// check how you can get firebase server key https://i.gyazo.com/7c3f23a30c14d3008533605a9821f944.png
    define("firebase_key","AAAA4Jks_Bo:APA91bGg1xJlLPFsuJu465FajgVL5G58E-2GnamlEuySgVQr6y4ARIsjwQ0L2u-u_fS0tslun4TvCdhYACqzTsWNnHOelOaJTAPXM6IgPjIgm1qZl-r4jN5m-ERL1fwF2cQYvCU8wS2j");

    //dont modify this
    define("STATUS","demo"); //live or demo
    define("API-KEY","4444-3333-2222-1111"); //dont change api key from here

    //amazon S3 configuration
    define("media_storage","s3");  // if you want to enable AWS s3 then you have to put the value "s3" and if you put "local" videos will be stored in your local server/hosting
    define("IAM_KEY","AKIA3ODGRRB7J2JYCH7Q");
    define("IAM_SECRET","mVorj7mFm8052P6/RGWE2EYEjukKG8BrjKrOmYFa");
    define("BUCKET_NAME","tictic-videos");
    define("S3_REGION","ap-south-1"); // specify here your bucket region. for example mine is  us-east-1


    // define("media_storage","s3");  // if you want to enable AWS s3 then you have to put the value "s3" and if you put "local" videos will be stored in your local server/hosting
    // define("IAM_KEY","Put your IAM_KEY here");
    // define("IAM_SECRET","Put your IAM_SECRET here");
    // define("BUCKET_NAME","Put your BUCKET_NAME here");
    // define("S3_REGION","put the aws region here"); // specify here your bucket region. for example mine is  us-east-1

	//database configration
	$servername = "localhost";
	$database = "bring_tictic";
	$username = "root";
	$password = " ";

// 	$servername = "localhost";  // dont change this most of hosting work with "localhost" only cloud work with ip address
// 	$database = "Your database name here";
// 	$username = "your databaes username here";
// 	$password = "Your database user password here";

	// Create connection
	$conn = mysqli_connect($servername, $username, $password, $database);
    mysqli_query($conn,"SET SESSION sql_mode = 'NO_ENGINE_SUBSTITUTION'");
	// Check connection

	if (!$conn) {

	    die("Connection failed: " . mysqli_connect_error());

	}


    use Aws\S3\S3Client;
    use Aws\S3\Exception\S3Exception;


    function uploadS3($filePath,$folder)
    {
        //require 'config.php';
        require 'vendor/autoload.php';

    	$bucketName = BUCKET_NAME;
    	$filePath = $filePath;
    	$keyName = basename($filePath);
    	//$keyName = time().rand().".mp4";

    	$IAM_KEY = IAM_KEY;
    	$IAM_SECRET = IAM_SECRET;

    	// Set Amazon S3 Credentials
    	$s3 = S3Client::factory(
    		array(
    			'credentials' => array(
    				'key' => $IAM_KEY,
    				'secret' => $IAM_SECRET
    			),
    			'version' => 'latest',
    			'region'  => S3_REGION
    		)
    	);


    	try {
    		// So you need to move the file on $filePath to a temporary place.
    		if (!file_exists('tmp/tmpfile')) {
    			mkdir('tmp/tmpfile');
    		}

    		// Create temp file
    		$tempFilePath = 'tmp/tmpfile/' . basename($filePath);
    		$tempFile = fopen($tempFilePath, "w") or die("Error: Unable to open file.");
    		$fileContents = file_get_contents($filePath);
    		$tempFile = file_put_contents($tempFilePath, $fileContents);


    		// Put on S3
    		$result = $s3->putObject(
    			array(
    				'Bucket'=>$bucketName,
    				'Key' =>  $folder."/".$keyName,
    				'ACL'    => 'public-read',
    				'SourceFile' => $tempFilePath,
    				'StorageClass' => 'REDUCED_REDUNDANCY'
    			)
    		);
    		return $result['ObjectURL'];

    		unlink($tempFilePath);
    	}
    	catch (S3Exception $e)
    	{
    		//echo $e->getMessage();
    		if(strpos($e->getMessage(),"NoSuchBucket")!="")
    		{
    		    define("s3_Error","NoSuchBucket");
    		}
    		else
    		if(strpos($e->getMessage(),"AccessDenied")!="")
    		{
    		    define("s3_Error","AccessDenied");
    		}
    	}
    	catch (Exception $e)
    	{
    		echo $e->getMessage();


    	}

    }

    function waterMark($videoURL,$username)
    {


        require 'video_editor/vendor/autoload.php';

		$ffmpeg = FFMpeg\FFMpeg::create(array(
            'ffmpeg.binaries'  => ffmpeg_lib,
            'ffprobe.binaries' => ffprobe_lib,
            'timeout'          => 3600, // The timeout for the underlying process
            'ffmpeg.threads'   => 12,   // The number of threads that FFMpeg should use
        ), null);
        $ffmpeg_string = ffprobe_lib;


        $tempFile=rand().time();
        $outputFile='tmp/'.$tempFile.'.mp4';

        $video = $ffmpeg->open($videoURL);

        $watermarkPath = watermark_Path;
        $video
            ->filters()
            ->watermark($watermarkPath, array(
                'position' => 'absolute',
                'x' => 15,
                'y' => 30,
            ));
        $text="@".$username;
        $command = "text='$text': fontcolor=white:fontfile=OpenSans-Bold.ttf: fontsize=18: x=20: y=70:";
        $format = new FFMpeg\Format\Video\X264();
        $format->setAudioCodec("aac");

        try
        {

                $video->filters()->custom("drawtext=$command");
                $video->save($format, $outputFile);

                $array_out = array();
    			$array_out[] =
    			array(
    			    "download_url" => checkVideoUrl($outputFile)
    			);

    			$output=array( "code" => "200", "msg" => $array_out);
    			print_r(json_encode($output, true));

        }
        catch(Exception $e)
        {
                echo $e->getMessage();
                die;
        }


    }



?>