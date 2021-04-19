package services;
import utils.Helper;
import utils.ZodiacDetails;
import io.grpc.stub.StreamObserver;
import proto.ZodiacGrpc;
import proto.ZodiacOuterClass;

import java.util.ArrayList;
import java.util.List;

public class ZodiacImpl extends ZodiacGrpc.ZodiacImplBase {
    private List<ZodiacDetails> zodiacList;
    private Helper operations;
    @Override
    public void returnZodiac(ZodiacOuterClass.BirthDateRequest request, StreamObserver<ZodiacOuterClass.ZodiacAnswer> responseObserver) {
        zodiacList=new ArrayList<>();
        operations=new Helper();

        operations.getZodiacFromFile(zodiacList);
        ZodiacOuterClass.ZodiacAnswer reply;
        if(request.getValidBirthDate()==false) {
            reply= ZodiacOuterClass.ZodiacAnswer.newBuilder().setZodiac("Invalid birth date!").build();
        }
        else
        {
            reply= ZodiacOuterClass.ZodiacAnswer.newBuilder().setZodiac(operations.returnZodiacForBirthDate(request.getDate(),zodiacList)).build();
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
